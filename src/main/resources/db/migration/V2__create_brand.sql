CREATE TABLE IF NOT EXISTS public.brand
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    brand_desc character varying(255) COLLATE pg_catalog."default",
    brand_name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    website character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT brand_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.brand
    OWNER to postgres;

CREATE SEQUENCE brand_sequence START WITH 1 INCREMENT BY 1;
