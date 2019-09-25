
package com.example.projectm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface  return_noteRepo extends CrudRepository<return_note, String> {

    List<return_note> findAll();

}