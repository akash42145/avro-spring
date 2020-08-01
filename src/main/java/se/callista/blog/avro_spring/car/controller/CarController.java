/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package se.callista.blog.avro_spring.car.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.callista.blog.avro_spring.car.avro.Car;
import se.callista.blog.avro_spring.car.persist.CarRepository;


@RestController
public class CarController {

  @Autowired
  private CarRepository repository;
  
  @RequestMapping(value = "/car", method = RequestMethod.GET, produces = "application/avro+json")
  public List<Car> getAllCar() {
	  List<Car> carCollection = repository.getAllCar();
	  System.out.println(carCollection);
	  
	  return carCollection;
	 
  }
  
  @RequestMapping(value = "/emps", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getAllEmp() {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("123456789", 123));
		emps.add(new Employee("987654321", 987));
		emps.add(new Employee("1", 123));
		return emps;
		
	}
  
  @RequestMapping(value = "/emp", method = RequestMethod.GET)
	public Employee getEmp() {
		
		
		return new Employee("123456789", 123);
		
	}


  @RequestMapping(value = "/car/{VIN}", method = RequestMethod.GET, produces = "application/avro+json")
  public Car getCar(@PathVariable("VIN") String VIN) {
    return repository.getCar(VIN);
  }

  @RequestMapping(value = "/car/{VIN}", method = RequestMethod.PUT, consumes = "application/avro+json",
      produces = "application/avro+json")
  public Car updateCar(@PathVariable("VIN") String VIN, @RequestBody Car car) {
    repository.updateCar(car);
    return car;
  }
}
