CREATE TABLE IF NOT EXISTS public.product_type
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    product_type character varying(255) COLLATE pg_catalog."default",
    product_type_desc character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT product_type_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_type
    OWNER to postgres;

CREATE SEQUENCE product_type_sequence_flyway START WITH 1 INCREMENT BY 1;
