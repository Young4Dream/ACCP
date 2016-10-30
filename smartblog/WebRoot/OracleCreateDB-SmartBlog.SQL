spool c:\PBSmartBlogDBCreateInfo.log;

-- 创建表空间
CREATE TABLESPACE BlogDB
DATAFILE 'BlogDB.dat' SIZE 100M AUTOEXTEND ON NEXT  10M MAXSIZE UNLIMITED;
-- 创建用户
--connect internal
CREATE USER BlogUser  IDENTIFIED BY BlogUser;
  
ALTER USER BlogUser IDENTIFIED BY BlogUser;
ALTER USER BlogUser DEFAULT   TABLESPACE BlogDB;
ALTER USER BlogUser DEFAULT 	ROLE ALL;
GRANT CONNECT TO BlogUser;
GRANT RESOURCE TO BlogUser;
GRANT create table to BlogUser;
GRANT create trigger to BlogUser;
--disconnect
spool out;
Exit;





