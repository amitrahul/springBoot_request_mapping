package com.backendapi.springbootcrud.springbootcrud.services;

import com.backendapi.springbootcrud.springbootcrud.dto.EmployeeDTO;
import com.backendapi.springbootcrud.springbootcrud.entites.EmployeeEntity;
import com.backendapi.springbootcrud.springbootcrud.exception.ResourceNotFoundException;
import com.backendapi.springbootcrud.springbootcrud.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO>  getEmployeeById(Long id) {
//        EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(null);
        /*
        * instead of return through object creating, we can achieve same thing from model mapper library.
        * bcz each time create object will be difficult one.
        *
        *
       return new EmployeeEntity(employeeEntity.getId() , employeeEntity.getName() , employeeEntity.getEmail() , employeeEntity.getAge() ,employeeEntity.getDateOfJoining(), employeeEntity.getIsActive());

         * */

//        ModelMapper mapper = new ModelMapper();
//        instead of creating ModelMapper object each time, we are creating beans of it, in config package.


//       return modelMapper.map(employeeEntity , EmployeeDTO.class);

//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));

//        in one line we can also write same thing as:-
       return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
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

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDto) {
        isExistByEmployeeId(employeeId);
      EmployeeEntity employeeEntity =  modelMapper.map(employeeDto, EmployeeEntity.class);
      employeeEntity.setId(employeeId);
      EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
      return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void isExistByEmployeeId(Long employeeId){
//        return employeeRepository.existsById(employeeId);
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) throw new ResourceNotFoundException("employee not found with id " + employeeId);
    }

    public boolean deleteEmployeeId(Long employeeId) {
         isExistByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }


    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
         isExistByEmployeeId(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field,value) -> {
           Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
           fieldToBeUpdated.setAccessible(true);
           ReflectionUtils.setField(fieldToBeUpdated, employeeEntity , value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
