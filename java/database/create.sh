#!/bin/bash

# **************************************************************
# Best Buds
# Creates and sets up the local PostgreSQL database
# **************************************************************

set -e

BASEDIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

DATABASE="${DB_NAME:-best_buds}"
DB_HOST="${DB_HOST:-localhost}"
ADMIN_USERNAME="${DB_ADMIN_USERNAME:-postgres}"
OWNER_USERNAME="${DB_OWNER_USERNAME:-best_buds_owner}"
APP_USERNAME="${DB_APP_USERNAME:-best_buds_appuser}"

# Make sure the required passwords are loaded
if [ -z "${DB_ADMIN_PASSWORD:-}" ]; then
    echo "DB_ADMIN_PASSWORD is not loaded."
    echo "Run: source ../load-env.sh"
    exit 1
fi

if [ -z "${DB_PASSWORD:-}" ]; then
    echo "DB_PASSWORD is not loaded."
    echo "Run: source ../load-env.sh"
    exit 1
fi

# Use the PostgreSQL administrator password
export PGPASSWORD="$DB_ADMIN_PASSWORD"

echo
echo "Creating Best Buds database..."

# Remove the existing database and roles
psql -h "$DB_HOST" -U "$ADMIN_USERNAME" \
    -v ON_ERROR_STOP=1 \
    -f "$BASEDIR/dropdb.sql"

# Create the database roles
psql -h "$DB_HOST" -U "$ADMIN_USERNAME" \
    -v ON_ERROR_STOP=1 \
    -f "$BASEDIR/user.sql"

# Set the application user's password
printf "%s\n%s\n" "$DB_PASSWORD" "$DB_PASSWORD" | \
    psql -h "$DB_HOST" -U "$ADMIN_USERNAME" \
    -v ON_ERROR_STOP=1 \
    -c "\\password $APP_USERNAME"

# Create the database
createdb -h "$DB_HOST" -U "$ADMIN_USERNAME" \
    -O "$OWNER_USERNAME" \
    "$DATABASE"

# Create the database tables
psql -h "$DB_HOST" -U "$ADMIN_USERNAME" -d "$DATABASE" \
    -v ON_ERROR_STOP=1 \
    -c "SET ROLE $OWNER_USERNAME;" \
    -f "$BASEDIR/schema.sql"

# Add development data
psql -h "$DB_HOST" -U "$ADMIN_USERNAME" -d "$DATABASE" \
    -v ON_ERROR_STOP=1 \
    -c "SET ROLE $OWNER_USERNAME;" \
    -f "$BASEDIR/data.sql"

# Give the application user access
psql -h "$DB_HOST" -U "$ADMIN_USERNAME" -d "$DATABASE" \
    -v ON_ERROR_STOP=1 \
    -c "GRANT CONNECT ON DATABASE $DATABASE TO $APP_USERNAME;" \
    -c "GRANT USAGE ON SCHEMA public TO $APP_USERNAME;" \
    -c "GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO $APP_USERNAME;" \
    -c "GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO $APP_USERNAME;"

echo
echo "Best Buds database created successfully."
echo "Database: $DATABASE"
echo "Application user: $APP_USERNAME"
