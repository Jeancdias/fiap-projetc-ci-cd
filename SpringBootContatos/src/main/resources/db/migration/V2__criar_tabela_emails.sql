CREATE SEQUENCE TBL_EMAIL_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_EMAIL (
    ID INTEGER DEFAULT TBL_EMAIL_SEQ.NEXTVAL NOT NULL,
    ENVIAR_PARA VARCHAR2(255) NOT NULL,
    ENVIAR_DE VARCHAR2(255) NOT NULL,
    ASSUNTO VARCHAR2(255) NOT NULL,
    BODY VARCHAR2(255) NOT NULL,
    DT_ENVIO DATE
);