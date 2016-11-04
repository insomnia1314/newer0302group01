----------------------------------------------------
-- Spring (4.1.0) + mybatis (3.3.0) + Oracle 11g  --
-- ������ܻ�����                                                                                                --
-- Created by SONG on 2016-09-21 16:21:21         --
----------------------------------------------------

create table SYS_CODES
(
  ID        NUMBER(6) not null,
  PARENT_ID NUMBER(6),
  CODE_ID   VARCHAR2(20),
  NAME      VARCHAR2(50),
  STATUS    VARCHAR2(20),
  DEF_VALUE VARCHAR2(20),
  DESCN     VARCHAR2(400)
)
;
comment on table SYS_CODES
  is '���������';
comment on column SYS_CODES.ID
  is '�����������ţ�����';
comment on column SYS_CODES.PARENT_ID
  is '�������';
comment on column SYS_CODES.CODE_ID
  is '������';
comment on column SYS_CODES.NAME
  is '��������';
comment on column SYS_CODES.STATUS
  is '״̬';
comment on column SYS_CODES.DEF_VALUE
  is 'Ĭ��ֵ';
comment on column SYS_CODES.DESCN
  is '˵��';
alter table SYS_CODES
  add constraint PK_SYS_CODES primary key (ID);
alter table SYS_CODES
  add constraint FK_SYS_CODE foreign key (PARENT_ID)
  references SYS_CODES (ID);


create table SYS_LOGS
(
  ID       NUMBER(6) not null,
  LOGIN_ID VARCHAR2(50),
  PRIORITY VARCHAR2(200),
  LOG_DATE DATE,
  CLASS    VARCHAR2(200),
  METHOD   VARCHAR2(200),
  MSG      VARCHAR2(400)
)
;
comment on table SYS_LOGS
  is '��־��Ϣ';
comment on column SYS_LOGS.ID
  is '��־��ţ�����';
comment on column SYS_LOGS.LOGIN_ID
  is '��½���';
comment on column SYS_LOGS.PRIORITY
  is '��־����';
comment on column SYS_LOGS.LOG_DATE
  is '��־��¼ʱ��';
comment on column SYS_LOGS.CLASS
  is '����д��־���������';
comment on column SYS_LOGS.METHOD
  is '����¼����־�еķ�����';
comment on column SYS_LOGS.MSG
  is '��־��ϸ��Ϣ';
alter table SYS_LOGS
  add constraint PK_SYS_LOGS primary key (ID);


create table SYS_MENUS
(
  ID        NUMBER(6) not null,
  PARENT_ID NUMBER(6),
  SEQ       NUMBER(6),
  NAME      VARCHAR2(50),
  DESCN     VARCHAR2(400),
  LINK_URL  VARCHAR2(200),
  STATUS    VARCHAR2(20)
)
;
comment on table SYS_MENUS
  is '�˵���Ϣ';
comment on column SYS_MENUS.ID
  is '�˵���ţ�����';
comment on column SYS_MENUS.PARENT_ID
  is '�������';
comment on column SYS_MENUS.SEQ
  is '�˵�����';
comment on column SYS_MENUS.NAME
  is '�˵�����';
comment on column SYS_MENUS.DESCN
  is '�˵�˵��';
comment on column SYS_MENUS.LINK_URL
  is '���ӵ�ַ';
comment on column SYS_MENUS.STATUS
  is '�Ƿ����';
alter table SYS_MENUS
  add constraint PK_SYS_MENUS primary key (ID);
alter table SYS_MENUS
  add constraint FK_SYS_MENUS_1 foreign key (PARENT_ID)
  references SYS_MENUS (ID);


create table SYS_ROLES
(
  ID    NUMBER(6) not null,
  NAME  VARCHAR2(50),
  CODE  VARCHAR2(50),
  DESCN VARCHAR2(400)
)
;
comment on table SYS_ROLES
  is '��ɫ��Ϣ';
comment on column SYS_ROLES.ID
  is '�û���ţ�����';
comment on column SYS_ROLES.NAME
  is '��ɫ����';
comment on column SYS_ROLES.CODE
  is '��ɫ���';
comment on column SYS_ROLES.DESCN
  is '��ɫ˵��';
alter table SYS_ROLES
  add constraint PK_SYS_ROLES primary key (ID);


create table SYS_MENU_ROLE
(
  MENU_ID NUMBER(6),
  ROLE_ID NUMBER(6)
)
;
comment on table SYS_MENU_ROLE
  is '�˵���ɫ��Ӧ��';
comment on column SYS_MENU_ROLE.MENU_ID
  is '�˵����';
comment on column SYS_MENU_ROLE.ROLE_ID
  is '��ɫ���';
alter table SYS_MENU_ROLE
  add constraint FK_SYS_MENUS_2 foreign key (MENU_ID)
  references SYS_MENUS (ID);
alter table SYS_MENU_ROLE
  add constraint FK_SYS_ROLES_1 foreign key (ROLE_ID)
  references SYS_ROLES (ID);

create table SYS_USERS
(
  ID         NUMBER(6) not null,
  USERNAME   VARCHAR2(50) not null,
  PASSWORD   VARCHAR2(50) not null,
  STATUS     VARCHAR2(20),
  PHOTO_PATH VARCHAR2(200)
)
;
comment on table SYS_USERS
  is 'ϵͳ�û���Ϣ';
comment on column SYS_USERS.ID
  is 'ϵͳ�û���ţ�����';
comment on column SYS_USERS.USERNAME
  is '�û���¼���';
comment on column SYS_USERS.PASSWORD
  is '�û�����';
comment on column SYS_USERS.STATUS
  is '�û�״̬����Ӧ������CODE_ID�ֶ�';
comment on column SYS_USERS.PHOTO_PATH
  is '�û���Ƭ·��';
alter table SYS_USERS
  add constraint PK_SYS_USERS primary key (ID);


create table SYS_USER_ROLE
(
  USER_ID NUMBER(6),
  ROLE_ID NUMBER(6)
)
;
comment on table SYS_USER_ROLE
  is '�û���ɫ��Ӧ��';
comment on column SYS_USER_ROLE.USER_ID
  is '�û����';
comment on column SYS_USER_ROLE.ROLE_ID
  is '��ɫ���';
alter table SYS_USER_ROLE
  add constraint FK_SYS_ROLES_2 foreign key (ROLE_ID)
  references SYS_ROLES (ID);
alter table SYS_USER_ROLE
  add constraint FK_SYS_USERS foreign key (USER_ID)
  references SYS_USERS (ID);


create sequence SEQ_SYS_CODES
minvalue 1
maxvalue 999999
start with 2
increment by 1
nocache
order;


create sequence SEQ_SYS_LOGS
minvalue 1
maxvalue 999999
start with 2
increment by 1
nocache
order;


create sequence SEQ_SYS_MENUS
minvalue 1
maxvalue 999999
start with 29
increment by 1
nocache
order;


create sequence SEQ_SYS_ROLES
minvalue 1
maxvalue 999999
start with 29
increment by 1
nocache
order;


create sequence SEQ_SYS_USERS
minvalue 1
maxvalue 999999
start with 8
increment by 1
nocache
order;


