-- Drop user first if they exist
DROP USER if exists 'springstudent'@'localhost';

-- now create new  user with prop privileges
CREATE USER 'springstudent'@'localhost' identified by 'springstudent';
			-- username                                password
grant all privileges on *.* to 'springstudent'@'localhost';