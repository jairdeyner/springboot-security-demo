package com.app.springsecurity;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.springsecurity.persistence.entity.PermissionEntity;
import com.app.springsecurity.persistence.entity.RoleEntity;
import com.app.springsecurity.persistence.entity.RoleEnum;
import com.app.springsecurity.persistence.entity.UserEntity;
import com.app.springsecurity.persistence.repository.UserRepository;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			PermissionEntity createPermission = PermissionEntity.builder().naem("CREATE").build();
			PermissionEntity readPermission = PermissionEntity.builder().naem("READ").build();
			PermissionEntity updatePermission = PermissionEntity.builder().naem("UPDATE").build();
			PermissionEntity deletePermission = PermissionEntity.builder().naem("DELETE").build();
			PermissionEntity refactorPermission = PermissionEntity.builder().naem("REFACTOR").build();

			RoleEntity roleAdmin = RoleEntity
					.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity
					.builder()
					.roleEnum(RoleEnum.USER)
					.permissions(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity
					.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissions(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper = RoleEntity
					.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission,
							refactorPermission))
					.build();

			UserEntity userSantiago = UserEntity
					.builder()
					.username("santiago")
					.password("$2a$10$veirixLXRNjy4UyK7fh7jeN3Y6V8inacKWaIehowx.NugFVJZ2Xi6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();
			UserEntity userDaniel = UserEntity
					.builder()
					.username("daniel")
					.password("$2a$10$veirixLXRNjy4UyK7fh7jeN3Y6V8inacKWaIehowx.NugFVJZ2Xi6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();
			UserEntity userAndrea = UserEntity
					.builder()
					.username("andrea")
					.password("$2a$10$veirixLXRNjy4UyK7fh7jeN3Y6V8inacKWaIehowx.NugFVJZ2Xi6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();
			UserEntity userAnyi = UserEntity
					.builder()
					.username("anyi")
					.password("$2a$10$veirixLXRNjy4UyK7fh7jeN3Y6V8inacKWaIehowx.NugFVJZ2Xi6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));
		};
	}
}
