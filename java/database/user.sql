-- **************************************************************
-- Best Buds
-- Creates the PostgreSQL roles used by the database
-- **************************************************************

-- Create the database owner role
DO
$$
BEGIN
    IF NOT EXISTS (
        SELECT FROM pg_catalog.pg_roles
        WHERE rolname = 'best_buds_owner'
    ) THEN
        CREATE ROLE best_buds_owner NOLOGIN;
    END IF;
END
$$;

-- Create the application user role
DO
$$
BEGIN
    IF NOT EXISTS (
        SELECT FROM pg_catalog.pg_roles
        WHERE rolname = 'best_buds_appuser'
    ) THEN
        CREATE ROLE best_buds_appuser LOGIN;
    END IF;
END
$$;
