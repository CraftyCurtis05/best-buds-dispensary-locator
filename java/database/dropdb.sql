-- **************************************************************
-- Best Buds
-- Removes the local PostgreSQL database and database roles
-- **************************************************************

-- Close active connections to the Best Buds database
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'best_buds'
  AND pid <> pg_backend_pid();

-- Remove the database
DROP DATABASE IF EXISTS best_buds;

-- Remove the database roles
DROP ROLE IF EXISTS best_buds_appuser;
DROP ROLE IF EXISTS best_buds_owner;
