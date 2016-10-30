spool c:\PBSmartBLogOracletable.log;

/***/
drop table Blog_Entry_Category;
drop table Blog_Comment;
drop table Blog_Entry;
drop table Blog_Category;
drop table Blog_User;

/* 1- 博客用户表   */

CREATE TABLE Blog_User
(
	ID						NUMBER(10, 0)		PRIMARY KEY NOT NULL,  
	UserName			VARCHAR2(50)		NOT NULL  ,
	NickName			VARCHAR2(100)		NOT NULL  ,
	Password			VARCHAR2(50)		NOT NULL  ,
	Gender			  NUMBER(5, 0)		NULL  ,
	Age			      NUMBER(5, 0)		NULL  ,
	mail			    VARCHAR2(50)		NULL  ,
	Site			    VARCHAR2(600)		NULL  
);

/* 2- 博客日志表   */

CREATE TABLE Blog_Entry
(
	ID						NUMBER(10, 0)		PRIMARY KEY NOT NULL,  
	Author			  NUMBER(10,0)		NOT NULL  ,
	Title			    VARCHAR2(500)		NOT NULL  ,
	Summary			  VARCHAR2(1024)	NULL  ,
	Content			  Clob		        NULL  ,
	ModifyTime		Date		        NULL  ,
	PostTime		  Date		        NULL  ,
	PostIP			  VARCHAR2(15)		NOT NULL  ,
	Hits			    NUMBER(5, 0)		NULL  ,
	CommentSize		NUMBER(5, 0)		NULL  ,
	EntryStatus	  VARCHAR2(20)		NULL,
	Constraint FK_Entry foreign key (Author) references Blog_User(ID)
);

commit; 

/* 3- 博客分类表   */

CREATE TABLE Blog_Category
(
	ID								NUMBER(10, 0)		PRIMARY KEY NOT NULL,  
	Name			    		VARCHAR2(100)		NOT NULL  ,
	Description				VARCHAR2(1000)	NULL  ,
	DefaultCategory		NUMBER(1, 0)		NOT NULL  ,
	CreateTime				Date		        NULL
);

commit; 

/* 4- 博客日志和分类关系表   */

CREATE TABLE Blog_Entry_Category
(
	EntryId								NUMBER(10, 0)		NOT NULL,  
	CategoryId			    	NUMBER(10, 0)		NOT NULL,
	Constraint FK_EntryCategory_Entry foreign key (EntryId) references Blog_Entry(ID),
	Constraint FK_EntryCategory_Category foreign key (CategoryId) references Blog_Category(ID)
);



/* 5- 博客评论表   */

CREATE TABLE Blog_Comment
(
	ID						NUMBER(10, 0)		PRIMARY KEY NOT NULL,  
	AuthorName	  VARCHAR2(50)		NOT NULL  ,
	AuthorSite		VARCHAR2(300)		NULL  ,
	AuthorMail		VARCHAR2(50)	  NULL  ,
	Content			  Clob		        NULL  ,
	PostTime		  Date		        NULL  ,
	PostIP			  VARCHAR2(15)		NOT NULL  ,
	EntryId	      NUMBER(10, 0)		NOT NULL  ,
	Constraint FK_Comment foreign key (EntryId) references Blog_Entry(ID)
);

/* 6- 站点配置表   */
drop table Blog_Site_Config;
CREATE TABLE Blog_Site_Config
(
	ID						NUMBER(10, 0)		PRIMARY KEY NOT NULL,  
	SiteName	    VARCHAR2(50)		NOT NULL  ,
	SiteAbout		  VARCHAR2(300)		NULL
);

commit; 

---------------------END--------------------------------------------------------------------
spool out;
Exit;
