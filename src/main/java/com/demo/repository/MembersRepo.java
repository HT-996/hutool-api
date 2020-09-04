package com.demo.repository;

import com.demo.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HuTing
 * @date 2020-09-04 17:15
 */
public interface MembersRepo extends JpaRepository<Members, Long> {
}
