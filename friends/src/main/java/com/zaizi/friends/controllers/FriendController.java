package com.zaizi.friends.controllers;

import com.zaizi.friends.model.Friend;
import com.zaizi.friends.services.FriendService;
import com.zaizi.friends.util.ErrorMessage;
import com.zaizi.friends.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FriendController {

  @Autowired
  FriendService friendService;

  //No Validation§ needed as we use the Java Validation API meaning we can just use the @Valid annotation
  @PostMapping("/friend")
  Friend create(@Valid @RequestBody Friend friend) {//throws ValidationException {
    //if(friend.getAge() == 0 && friend.getFirstName() != null && friend.getLastName() != null) {
      return friendService.save(friend);
    //}
    //  else throw new ValidationException("Friend cannot be created");
  }

//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler()
//  ErrorMessage exceptionHandler(ValidationException exception){
//    return  new ErrorMessage(HttpStatus.BAD_REQUEST.value()+ "", exception.getMessage());
//  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException exception){
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    List<FieldErrorMessage> fieldErrorMessages =
            fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),
            fieldError.getDefaultMessage())).collect(Collectors.toList());

    return fieldErrorMessages;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  String exceptionHandler(ValidationException e) {
    return e.getMessage();
  }

  @GetMapping("/friend")
  Iterable<Friend> read() {
    return friendService.findAll();
  }

  @GetMapping("/wrong")
  Friend somethingIsWrong() throws ValidationException {
    throw new ValidationException("Something is wrong");
  }

  @PutMapping("/friend")
  ResponseEntity<Friend> update(@RequestBody Friend friend) {
    if(friendService.findById(friend.getId()).isPresent()){
      return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
    } else {
      return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("/friend/{id}")
  void delete(@PathVariable Integer id) {
    friendService.deleteById(id);
  }
}
