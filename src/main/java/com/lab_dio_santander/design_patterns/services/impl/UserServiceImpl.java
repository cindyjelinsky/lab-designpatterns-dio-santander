package com.lab_dio_santander.design_patterns.services.impl;

import com.lab_dio_santander.design_patterns.model.Address;
import com.lab_dio_santander.design_patterns.model.User;
import com.lab_dio_santander.design_patterns.repository.AddressRepository;
import com.lab_dio_santander.design_patterns.repository.UserRepository;
import com.lab_dio_santander.design_patterns.services.CepAddressService;
import com.lab_dio_santander.design_patterns.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CepAddressService cepAddressService;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void create(User user) {
       saveUserCep(user);

    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userDb =  userRepository.findById(id);
        if(userDb.isPresent()){
            saveUserCep(user);
        }

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void saveUserCep(User user) {

        String cep = user.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {

            Address newAddress = cepAddressService.checkCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
       user.setAddress(address);
       userRepository.save(user);
    }
}
