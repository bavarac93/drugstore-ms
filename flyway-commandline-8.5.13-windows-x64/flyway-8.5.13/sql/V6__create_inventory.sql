CREATE TABLE IF NOT EXISTS public.inventory
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified_at timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    expiry_date date,
    item_name character varying(255) COLLATE pg_catalog."default",
    price bigint,
    quantity bigint,
    sku character varying(255) COLLATE pg_catalog."default",
    sold bigint,
    brand_id bigint,
    product_type_id bigint,
    supplier_id bigint,
    CONSTRAINT inventory_pkey PRIMARY KEY (id),
    CONSTRAINT fk2xwi243k0x6l0ya9vx2ie1tik FOREIGN KEY (product_type_id)
        REFERENCES public.product_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fke0810rp6mmsbj1f46yhc4h7vb FOREIGN KEY (supplier_id)
        REFERENCES public.supplier (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fknso6r3df9gjd8ow0x8fomuo2a FOREIGN KEY (brand_id)
        REFERENCES public.brand (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.inventory
    OWNER to muki;

CREATE SEQUENCE inventory_sequence START WITH 1 INCREMENT BY 1;
