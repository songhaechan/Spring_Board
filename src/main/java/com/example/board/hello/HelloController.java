package com.example.board.hello;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HelloController {
  @GetMapping
  public String hello() {
    return "hello world";
  }

  @GetMapping("/{num}")
  public Integer plusOne(@PathVariable Integer num) {
    return num +1;
  }

  @PostMapping
  public Hello posthello(@RequestBody Hello hello){
    return hello;
  }

  @GetMapping("/{a}/{b}")
  public Hello makeHello(@PathVariable Integer a, @PathVariable Integer b){
    return new Hello(a, b);
  }

}
