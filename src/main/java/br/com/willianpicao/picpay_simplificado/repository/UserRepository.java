package br.com.willianpicao.picpay_simplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.willianpicao.picpay_simplificado.entity.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
