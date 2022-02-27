package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.mapper.CustomerMapper;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.service.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customer")
public class  CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    @PostMapping("")
    public ResponseEntity<Customer> add(@Valid @RequestBody CustomerDto customerDto) {
        final Customer customer = customerService.add(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable long id) {
        final Optional<Customer> optionalCustomer = customerService.findById(id);
        return optionalCustomer.map(customer -> ResponseEntity.ok(CustomerMapper.mapToDto(customer))).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("")
    public List<CustomerDto> findAll(){
        return customerService.findAll().stream()
                .map(CustomerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        customerService.deleteById(id);
    }

}