-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER best_buds_owner
WITH PASSWORD 'bestbuds';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO best_buds_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO best_buds_owner;

CREATE USER best_buds_appuser
WITH PASSWORD 'bestbuds';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO best_buds_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO best_buds_appuser;
