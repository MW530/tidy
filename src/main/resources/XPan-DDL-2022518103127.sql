DROP TABLE IF EXISTS user_user;
CREATE TABLE user_user(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    username VARCHAR(255) NOT NULL   COMMENT '用户名' ,
    password VARCHAR(255) NOT NULL   COMMENT '密码' ,
    salt VARCHAR(255) NOT NULL   COMMENT '密码盐' ,
    uuid VARCHAR(255) NOT NULL   COMMENT 'uuid' ,
    email VARCHAR(255) NOT NULL   COMMENT '邮箱' ,
    avatar VARCHAR(255) NOT NULL   COMMENT '用户头像' ,
    background_img VARCHAR(255) NOT NULL   COMMENT '主页背景图' ,
    role VARCHAR(255) NOT NULL   COMMENT '角色' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '最近修改时间' ,
    redundnecy1 VARCHAR(255)    COMMENT '冗余字段1' ,
    redundnecy2 VARCHAR(255)    COMMENT '冗余字段2' ,
    PRIMARY KEY (id)
)  COMMENT = '用户';

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    role_name VARCHAR(255) NOT NULL   COMMENT '角色名' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '修改时间' ,
    redundancy1 VARCHAR(255)    COMMENT '冗余字段1' ,
    PRIMARY KEY (id)
)  COMMENT = '角色表';

DROP TABLE IF EXISTS user_permission;
CREATE TABLE user_permission(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    permission_name VARCHAR(255) NOT NULL   COMMENT '权限名称' ,
    icon VARCHAR(255) NOT NULL   COMMENT '图标' ,
    pid INT NOT NULL   COMMENT '父级id' ,
    url VARCHAR(255) NOT NULL   COMMENT '路由地址' ,
    type VARCHAR(255) NOT NULL   COMMENT '资源类型：button, menu, element' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '修改时间' ,
    redundancy1 VARCHAR(255)    COMMENT '冗余字段1' ,
    redundancy2 VARCHAR(255)    COMMENT '冗余字段2' ,
    PRIMARY KEY (id)
)  COMMENT = '权限表';

DROP TABLE IF EXISTS user_user_role;
CREATE TABLE user_user_role(
    id INT NOT NULL   COMMENT 'id' ,
    user_id INT NOT NULL   COMMENT '用户id' ,
    role_id VARCHAR(255) NOT NULL   COMMENT '角色id' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '映射创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '映射修改时间' ,
    redundancy VARCHAR(255)    COMMENT '冗余字段' ,
    PRIMARY KEY (id)
)  COMMENT = '用户角色表';

DROP TABLE IF EXISTS user_role_permission;
CREATE TABLE user_role_permission(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '角色权限id' ,
    role_id VARCHAR(255) NOT NULL   COMMENT '角色id' ,
    permission_id VARCHAR(255) NOT NULL   COMMENT '权限id' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '映射创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '映射修改时间' ,
    redundancy VARCHAR(255) NOT NULL   COMMENT '冗余字段' ,
    PRIMARY KEY (id)
)  COMMENT = '角色权限表';

DROP TABLE IF EXISTS file_folder;
CREATE TABLE file_folder(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '文件夹id' ,
    user_id INT NOT NULL   COMMENT '用户id' ,
    folder_name VARCHAR(500) NOT NULL   COMMENT '文件夹名称' ,
    depth INT    COMMENT '文件夹深度' ,
    icon VARCHAR(255) NOT NULL   COMMENT '文件夹图标' ,
    pid VARCHAR(255) NOT NULL   COMMENT '父级目录id' ,
    size INT NOT NULL   COMMENT '目录文件大小' ,
    sub_folder_num INT NOT NULL   COMMENT '子目录数量' ,
    sub_folder VARCHAR(255)    COMMENT '子文件夹列表（索引id，逗号分割）' ,
    sub_file_num INT NOT NULL   COMMENT '子文件数量' ,
    sub_file VARCHAR(255)    COMMENT '子文件列表（索引hash，逗号分割）' ,
    gmt_statistics VARCHAR(255) NOT NULL   COMMENT '子资源统计时间' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '修改时间' ,
    redundancy1 VARCHAR(255)    COMMENT '冗余字段1' ,
    redundancy2 VARCHAR(255)    COMMENT '冗余字段2' ,
    PRIMARY KEY (id)
)  COMMENT = '文件夹表';

DROP TABLE IF EXISTS file_user_file;
CREATE TABLE file_user_file(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '用户文件映射id' ,
    user_id VARCHAR(255) NOT NULL   COMMENT '用户id' ,
    file_hash VARCHAR(255) NOT NULL   COMMENT '文件hash' ,
    pid INT NOT NULL   COMMENT '父级目录' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '映射创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '映射更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '用户文件表';

DROP TABLE IF EXISTS file_file;
CREATE TABLE file_file(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '文件id' ,
    file_name VARCHAR(500) NOT NULL   COMMENT '文件名' ,
    type VARCHAR(255) NOT NULL   COMMENT '文件类型:img, music, video, e-book, text, pdf, excel, word' ,
    hash VARCHAR(255) NOT NULL   COMMENT '文件hash值' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '文件创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '文件更新时间' ,
    redundancy VARCHAR(255)    COMMENT '冗余字段' ,
    PRIMARY KEY (id)
)  COMMENT = '文件表';

DROP TABLE IF EXISTS file_share;
CREATE TABLE file_share(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    user_id VARCHAR(255) NOT NULL   COMMENT '用户id' ,
    resource_id INT NOT NULL   COMMENT '文件或文件夹id' ,
    url VARCHAR(255) NOT NULL   COMMENT '下载地址' ,
    is_encryption VARCHAR(255) NOT NULL   COMMENT '是否加密' ,
    password VARCHAR(255)    COMMENT '加密密码' ,
    activate VARCHAR(255)    COMMENT '是否启用' ,
    gmt_valid VARCHAR(255) NOT NULL   COMMENT '有效日期' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '更新时间' ,
    redundancy VARCHAR(255)    COMMENT '冗余字段' ,
    PRIMARY KEY (id)
)  COMMENT = '文件分享表';

DROP TABLE IF EXISTS collection_questionnaire;
CREATE TABLE collection_questionnaire(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    title VARCHAR(255) NOT NULL   COMMENT '问卷标题' ,
    sub_title VARCHAR(255) NOT NULL   COMMENT '副标题' ,
    direction VARCHAR(255)    COMMENT '说明' ,
    complete_msg VARCHAR(255)    COMMENT '完成提示语' ,
    gmt_start VARCHAR(255) NOT NULL   COMMENT '问卷开始时间' ,
    gmt_end VARCHAR(255) NOT NULL   COMMENT '问卷结束时间' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '问卷创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '问卷修改时间' ,
    PRIMARY KEY (id)
)  COMMENT = '问卷表';

DROP TABLE IF EXISTS collection_question_type;
CREATE TABLE collection_question_type(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    type_name VARCHAR(255)    COMMENT '题型名字' ,
    gmt_create VARCHAR(255)    COMMENT '题型创建时间' ,
    gmt_update VARCHAR(255)    COMMENT '题型修改时间' ,
    PRIMARY KEY (id)
)  COMMENT = '题型表';

DROP TABLE IF EXISTS collection_question;
CREATE TABLE collection_question(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    title VARCHAR(255) NOT NULL   COMMENT '问题标题' ,
    direction VARCHAR(255) NOT NULL   COMMENT '问题题干' ,
    is_require VARCHAR(255) NOT NULL   COMMENT '是否必答题' ,
    questionnaire INT NOT NULL   COMMENT '问卷id' ,
    question_type INT NOT NULL   COMMENT '问题类型' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '问题创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '问题更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '问题表';

DROP TABLE IF EXISTS colleciton_option;
CREATE TABLE colleciton_option(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    question_id VARCHAR(255) NOT NULL   COMMENT '问题id' ,
    option_content VARCHAR(255) NOT NULL   COMMENT '选项内容' ,
    gmt_create VARCHAR(255)    COMMENT '选项创建时间' ,
    gmt_update VARCHAR(255)    COMMENT '选项修改时间' ,
    PRIMARY KEY (id)
)  COMMENT = '选项表';

DROP TABLE IF EXISTS collection_answer;
CREATE TABLE collection_answer(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    user_id VARCHAR(255)    COMMENT '用户id' ,
    question_id INT NOT NULL   COMMENT '问题id' ,
    option_id INT NOT NULL   COMMENT '选项id' ,
    gmt_create VARCHAR(255) NOT NULL   COMMENT '回答创建时间' ,
    gmt_update VARCHAR(255) NOT NULL   COMMENT '回答修改时间' ,
    PRIMARY KEY (id)
)  COMMENT = '回答表';

DROP TABLE IF EXISTS sys_site_info;
CREATE TABLE sys_site_info(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '信息id' ,
    title VARCHAR(255) NOT NULL   COMMENT '站点标题' ,
    sub_title VARCHAR(255) NOT NULL   COMMENT '站点副标题' ,
    icon VARCHAR(255) NOT NULL   COMMENT '图标' ,
    description VARCHAR(255) NOT NULL   COMMENT '站点描述' ,
    url VARCHAR(255) NOT NULL   COMMENT '站点地址' ,
    footer_code VARCHAR(255) NOT NULL   COMMENT '页脚代码' ,
    PRIMARY KEY (id)
)  COMMENT = '站点信息';

DROP TABLE IF EXISTS sys_site_security;
CREATE TABLE sys_site_security(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '设置id' ,
    is_permit_new VARCHAR(1) NOT NULL   COMMENT '是否允许新用户注册' ,
    is_email_activate VARCHAR(1) NOT NULL   COMMENT '是否允许邮件激活' ,
    is_verification_code_register VARCHAR(1) NOT NULL   COMMENT '是否在激活时需要验证码' ,
    is_verification_code_login VARCHAR(1) NOT NULL   COMMENT '是否在登录时需要验证码' ,
    is_permit_retrieve_password VARCHAR(1) NOT NULL   COMMENT '是否允许找回密码' ,
    PRIMARY KEY (id)
)  COMMENT = '系统安全表';

DROP TABLE IF EXISTS sys_theme;
CREATE TABLE sys_theme(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '主题配色id' ,
    color1 VARCHAR(255) NOT NULL   COMMENT '颜色1;颜色1' ,
    color2 VARCHAR(255)    COMMENT '颜色2;颜色2' ,
    color3 VARCHAR(255)    COMMENT '颜色3;颜色3' ,
    PRIMARY KEY (id)
)  COMMENT = '站点主题表';

DROP TABLE IF EXISTS sys_email;
CREATE TABLE sys_email(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '项目id' ,
    send_name VARCHAR(255) NOT NULL   COMMENT '发送名字' ,
    email VARCHAR(255) NOT NULL   COMMENT '发送邮箱' ,
    SMTP_server VARCHAR(255)    COMMENT 'SMTP服务器' ,
    SMTP_port VARCHAR(255)    COMMENT 'SMTP端口' ,
    SMTP_name VARCHAR(255)    COMMENT 'SMTP名字' ,
    SMTP_password VARCHAR(255)    COMMENT 'SMTP密码' ,
    email_template_activate VARCHAR(255)    COMMENT 'email新用户激活模板' ,
    email_template_retrieve_password VARCHAR(255)    COMMENT 'email找回密码模板' ,
    PRIMARY KEY (id)
)  COMMENT = '系统邮箱设置表';

