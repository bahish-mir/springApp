package lab.assist.model.repositories;

import lab.assist.model.entity.User;
import lab.assist.constants.AppConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserById(int id);
    User findUserByLoginAndPassword(String login, String password);

    @Modifying
    @Transactional
    @Query(value = AppConstant.INSERT_USER_QUERY, nativeQuery = true)
    User createUser(@Param(AppConstant.LOGIN_COL) String login, @Param(AppConstant.PASSWORD_COL) String password);
}
