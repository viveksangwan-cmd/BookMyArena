package com.bookmyarena.Backend.Controllers;

import com.bookmyarena.Backend.Models.Address;
import com.bookmyarena.Backend.Models.Role;
import com.bookmyarena.Backend.Models.User;
import com.bookmyarena.Backend.Service.IFileStorageService;
import com.bookmyarena.Backend.Service.UserService;
import com.bookmyarena.Backend.Utils.Generate;
import com.bookmyarena.Backend.Utils.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    IFileStorageService fileStorageService;

    @Value("upload/${user_image_upload_path}")
    private String upload_path;


    @GetMapping("/profile")
    public User getUserProfile(@RequestParam int id){
        User user = userService.findById(id);
        return user;
    }

    @PostMapping()
    public User registerUser(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam MultipartFile image,
            @RequestParam(required = false) String contact,
            @RequestParam(required = false) String line1,
            @RequestParam(required = false) String line2,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String pincode){
        String imagePath = fileStorageService.save(image, Generate.fileName(image.getOriginalFilename()),upload_path);
        User user = new User();
        Role userrole = new Role();
        userrole.setRoleType(RoleType.USER);
        user.getRoles().add(userrole);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setImageUrl(imagePath);
        user.setActive(true);
        user.setContact(contact);
        user.setPassword(password);
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setCity(city);
        address.setCountry(country);
        address.setPincode(Integer.valueOf(pincode));
        address.setState(state);
        user.getAddresses().add(address);
        userService.createUser(user);

        return user;
    }
}
