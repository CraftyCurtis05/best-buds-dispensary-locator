#!/bin/bash

#source ../load-env.sh

# **************************************************************
# Best Buds
# Loads the local development environment
# **************************************************************

PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ENV_FILE="$PROJECT_ROOT/.env"

# Make sure the local environment file exists
if [ ! -f "$ENV_FILE" ]; then
    echo "Best Buds .env file was not found."
    return 1
fi

# Export variables from .env
set -a
source "$ENV_FILE"
set +a

echo "Best Buds local environment loaded."
