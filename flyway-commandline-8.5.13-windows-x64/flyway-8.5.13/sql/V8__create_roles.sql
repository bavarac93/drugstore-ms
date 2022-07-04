CREATE TABLE IF NOT EXISTS public.roles
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT roles_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.roles
    OWNER to muki;

CREATE SEQUENCE roles_sequence START WITH 1 INCREMENT BY 1;
