package com.security.secured.Repositories;

import com.security.secured.Entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepo extends JpaRepository<Form,Long> {

}
