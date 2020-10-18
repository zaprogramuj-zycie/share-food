package pl.zz.sharefood.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zz.sharefood.domain.User;
import pl.zz.sharefood.repository.UserRepository;
import pl.zz.sharefood.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
