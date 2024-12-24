package com.backendapi.springbootcrud.springbootcrud.services;

import com.backendapi.springbootcrud.springbootcrud.dto.EmployeeDTO;
import com.backendapi.springbootcrud.springbootcrud.entites.EmployeeEntity;
import com.backendapi.springbootcrud.springbootcrud.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(null);
        /*
        * instead of return through object creating, we can achieve same thing from model mapper library.
        * bcz each time create object will be difficult one.
        *
        *
       return new EmployeeEntity(employeeEntity.getId() , employeeEntity.getName() , employeeEntity.getEmail() , employeeEntity.getAge() ,employeeEntity.getDateOfJoining(), employeeEntity.getIsActive());

         * */

//        ModelMapper mapper = new ModelMapper();
//        instead of creating ModelMapper object each time, we are creating beans of it, in config package.


       return modelMapper.map(employeeEntity , EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
       List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
       return employeeEntityList
               .stream()
               .map(employeeEntity -> modelMapper.map(employeeEntity , EmployeeDTO.class))
               .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeInput) {
        EmployeeEntity toSaveEntity = modelMapper.map(employeeInput , EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

}
