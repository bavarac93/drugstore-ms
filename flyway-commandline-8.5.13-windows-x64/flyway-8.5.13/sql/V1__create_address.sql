CREATE TABLE IF NOT EXISTS public.address
(
    id bigint NOT NULL,
    building_number character varying(255) COLLATE pg_catalog."default",
    created_at timestamp without time zone,
    city character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    postcode character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT address_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.address
    OWNER to muki;


CREATE SEQUENCE address_sequence START WITH 1 INCREMENT BY 1;
