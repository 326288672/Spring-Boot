package com.wang.exception.interfaces;
import com.wang.exception.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by HP on 2018/7/31.
 */

public interface GirlRepository  extends JpaRepository<Girl,Integer> {
}
