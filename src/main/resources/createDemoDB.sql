DROP TABLE txnlog;

CREATE TABLE txnlog
(
    txnid character varying(255) COLLATE pg_catalog."default",
    merchantid character varying(255) COLLATE pg_catalog."default",
    merchantname character varying(255) COLLATE pg_catalog."default",
    amount character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    rejectreason character varying(255) COLLATE pg_catalog."default",
    txndate character varying(255) COLLATE pg_catalog."default",
    testq character varying(255) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE txnlog
    OWNER to postgres;

GRANT ALL ON TABLE txnlog TO postgres;