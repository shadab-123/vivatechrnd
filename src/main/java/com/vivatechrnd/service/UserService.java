package com.vivatechrnd.service;
import com.vivatechrnd.model.User;
import com.vivatechrnd.repository.UserRepository;
import com.vivatechrnd.util.OtpUtil;
import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private OtpUtil otpUtil;
  @Autowired
  private UserRepository userRepository;

  public String register() {
    String otp = otpUtil.generateOtp();
    User user = new User();
    user.setOtp(otp);
    user.setOtpGeneratedTime(LocalDateTime.now());
    userRepository.save(user);
    return "otp generated successful";
  }

  public String verifyAccount(String otp) {
    User user = userRepository.findOne(otp)
        .orElseThrow(() -> new RuntimeException("not found"));
    if (user.getOtp().equals(otp) && Duration.between(user.getOtpGeneratedTime(),
        LocalDateTime.now()).getSeconds() < (1 * 60)) {
      userRepository.save(user);
      return "OTP verified";
    }
    return "Please regenerate otp and try again";
  }
}
