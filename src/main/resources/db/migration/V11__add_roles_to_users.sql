CREATE TABLE IF NOT EXISTS public.users_entity_roles
(
    users_entity_id bigint NOT NULL,
    roles_id bigint NOT NULL,
    CONSTRAINT FKqhv300wni4ac56vwbqbeqa6fi FOREIGN KEY (users_entity_id)
        REFERENCES public.users_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users_entity_roles
    OWNER to postgres;

