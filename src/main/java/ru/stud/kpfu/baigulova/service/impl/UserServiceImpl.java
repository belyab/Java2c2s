package ru.stud.kpfu.baigulova.service.impl;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.stud.kpfu.baigulova.config.MailConfig;
import ru.stud.kpfu.baigulova.dto.CreateUserDto;
import ru.stud.kpfu.baigulova.dto.UserDto;
import ru.stud.kpfu.baigulova.helper.PasswordHelper;
import ru.stud.kpfu.baigulova.model.User;
import ru.stud.kpfu.baigulova.repository.UserRepository;
import ru.stud.kpfu.baigulova.service.UserService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final JavaMailSender javaMailSender;
    private final MailConfig mailConfig;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder, JavaMailSender javaMailSender, MailConfig mailConfig) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.javaMailSender = javaMailSender;
        this.mailConfig = mailConfig;
    }
    @Override
    public User getByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userRepository.findById(id).orElse(new User("elmira",
                "belyab@mail.ru", "1", Collections.emptyList(), "123"));
        return UserDto.fromModel(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public UserDto save(CreateUserDto user, String url) {
        String code = RandomString.make(64);
        sendVerificationMail(user.getEmail(), user.getName(), code, url);
        return UserDto.fromModel(userRepository.save(new User(user.getName(), user.getEmail(),encoder.encode(user.getPassword()), Collections.emptyList(), code)));
    }

    @Override
    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user != null) {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }

        return false;
    }

    @Override
    public void sendVerificationMail(String mail, String name, String code, String url) {
        String from = mailConfig.getFrom();
        String sender = mailConfig.getSender();
        String subject = mailConfig.getSubject();
        String content = mailConfig.getContent();


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom(from, sender);

            helper.setTo(mail);
            helper.setSubject(subject);

            content = content.replace("{name}", name);
            content = content.replace("{url}", url + "/verification?code=" + code);

            helper.setText(content, true);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
}
