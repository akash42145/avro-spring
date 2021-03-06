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

package se.callista.blog.avro_spring.car.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import se.callista.blog.avro_spring.car.avro.Car;
import se.callista.blog.avro_spring.car.avro.serde.CarSerDe;


@Repository
public class CarRepositoryImpl implements CarRepository {

  Map<String, Car> cars = new HashMap<>();
  List<Car> carCollection = new ArrayList<>();

  @PostConstruct
  private void initCars() {
    cars.put("123456789", new Car("123456789", "ABC 123"));
    cars.put("987654321", new Car("987654321", "XYZ 987"));
    
    carCollection.add(new Car("123456789", "ABC 123"));
    carCollection.add(new Car("987654321", "XYZ 987"));
    carCollection.add(new Car("1", "ABC 123"));
    carCollection.add(new Car("2", "XYZ 987"));
    carCollection.add(new Car("3", "ABC 123"));
    carCollection.add(new Car("4", "XYZ 987"));
    carCollection.add(new Car("5", "ABC 123"));
    carCollection.add(new Car("6", "XYZ 987"));
    carCollection.add(new Car("7", "ABC 123"));
    carCollection.add(new Car("987654321", "XYZ 987"));
    
  }

  @Override
  public Car getCar(String VIN) {
    return cars.get(VIN);
  }

  @Override
  public Car updateCar(Car car) {
    cars.put(car.getVIN().toString(), car);
    return car;
  }

@Override
public List<Car> getAllCar() {

	CarSerDe carSerDe = new CarSerDe(true);
	
	
	
	
	return carSerDe.deserializeList(carSerDe.serializeList(carCollection));
}

}
