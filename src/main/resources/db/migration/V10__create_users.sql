CREATE TABLE IF NOT EXISTS public.users_entity
(
    id bigint NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

CREATE SEQUENCE users_entity_sequence START WITH 1 INCREMENT BY 1;
