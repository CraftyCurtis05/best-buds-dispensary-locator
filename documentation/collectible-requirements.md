# Best Buds Collectible Requirements

## Purpose

Best Buds Drops reward users for exploring the application,
learning about cannabis, finding dispensaries, and returning over time.

The frontend records meaningful user activity.

The backend decides whether the recorded activity or application data
meets the requirements for a Drop.

This keeps collectible rules in one trusted place and prevents the
frontend from deciding which Drops a user has earned.


## Activity Types

Best Buds currently records these user activity types:

- `APP_VISIT`
- `DISPENSARY_VIEW`
- `AREA_SEARCH`
- `ARTICLES_VIEW`
- `EDUCATION_VIEW`
- `PRODUCTS_VIEW`
- `SAFETY_VIEW`


## Drop Requirements

### 01 - First Contact

**Code:** `FIRST_CONTACT`

**Requirement:**

View at least one dispensary.

**Data source:**

`DISPENSARY_VIEW`

**Status:**

Implemented.


### 02 - Night Owl

**Code:** `NIGHT_OWL`

**Requirement:**

Use Best Buds between 12:00 AM and 4:59 AM.

**Data source:**

Current server time when Drops are checked.

**Status:**

Implemented.


### 03 - Off the Map

**Code:** `OFF_THE_MAP`

**Requirement:**

Search for a dispensary area outside the user's home area.

**Data source:**

`AREA_SEARCH` and the user's saved home location.

**Implementation note:**

The searched location and home location need a reliable comparison.
Do not compare raw location strings.

**Status:**

Deferred until location context is finalized.


### 04 - Explorer

**Code:** `EXPLORER`

**Requirement:**

Record at least 5 distinct user activity types.

**Data source:**

`user_activities`

**Measurement:**

`COUNT(DISTINCT activity_type) >= 5`

**Status:**

Implemented and tested.


### 05 - Curator

**Code:** `CURATOR`

**Requirement:**

Save at least 10 dispensaries.

**Data source:**

Saved dispensary data.

**Measurement:**

`COUNT(saved_dispensaries) >= 10` for the authenticated user.

**Status:**

Implemented and tested.


### 06 - Stashed

**Code:** `STASHED`

**Requirement:**

Earn at least one other Drop.

**Data source:**

`user_collectibles`

**Measurement:**

`COUNT(user_collectibles) >= 1` before `STASHED` is unlocked.

Stashed runs after the normal Drop rules so a Drop earned during
the current check can immediately qualify the user.

**Implementation note:**

This rule should run after normal Drop rules so a Drop earned during
the current check can immediately qualify the user for Stashed.

**Status:**

Implemented and tested.


### 07 - Deep Dive

**Code:** `DEEP_DIVE`

**Requirement:**

Open at least 3 distinct educational articles.

**Data source:**

`ARTICLES_VIEW`

**Measurement:**

`COUNT(DISTINCT activity_value) >= 3`

**Status:**

Implemented.


### 08 - Well Informed

**Code:** `WELL_INFORMED`

**Requirement:**

Explore at least 5 distinct education topics.

**Data source:**

`EDUCATION_VIEW`

**Measurement:**

`COUNT(DISTINCT activity_value) >= 5`

**Status:**

Implemented.


### 09 - Know Your Buds

**Code:** `KNOW_YOUR_BUDS`

**Requirement:**

Explore both the strain guide and terpene guide and explore
at least 3 distinct product categories.

**Data sources:**

- `EDUCATION_VIEW`
- `PRODUCTS_VIEW`

**Required education values:**

- `strain-guide`
- `terpenes`

**Measurement:**

Both `strain-guide` and `terpenes` must exist as
`EDUCATION_VIEW` activity values.

`COUNT(DISTINCT PRODUCTS_VIEW activity_value) >= 3`

**Status:**

Implemented and tested.


### 10 - Read the Label

**Code:** `READ_THE_LABEL`

**Requirement:**

Explore all 6 product categories.

**Data source:**

`PRODUCTS_VIEW`

**Required values:**

- `flower`
- `edible`
- `wax`
- `oil`
- `tincture`
- `topical`

**Measurement:**

`COUNT(DISTINCT activity_value) >= 6`

**Status:**

Implemented.


### 11 - Safety First

**Code:** `SAFETY_FIRST`

**Requirement:**

Explore at least one safety topic.

**Data source:**

`SAFETY_VIEW`

**Measurement:**

At least 1 safety activity.

**Status:**

Implemented.


### 12 - Clear Head

**Code:** `CLEAR_HEAD`

**Requirement:**

Explore all 4 safety topics.

**Data source:**

`SAFETY_VIEW`

**Required values:**

- `thc`
- `cbd`
- `smoking`
- `topical`

**Measurement:**

`COUNT(DISTINCT activity_value) >= 4`

**Status:**

Implemented.


### 13 - Undiscovered

**Code:** `UNDISCOVERED`

**Requirement:**

Secret Drop.

**Implementation note:**

The final interaction that unlocks this Drop still needs to be defined.
Do not implement it until the requirement is explicit.

**Status:**

Requirement pending.


### 14 - The Regular

**Code:** `THE_REGULAR`

**Requirement:**

Visit Best Buds on at least 5 distinct dates.

**Data source:**

`APP_VISIT`

**Measurement:**

`COUNT(DISTINCT activity_value) >= 5`

`APP_VISIT` stores the user's local calendar date in `activity_value`
using the `YYYY-MM-DD` format.

**Status:**

Implemented and tested.


### 15 - Completionist

**Code:** `COMPLETIONIST`

**Requirement:**

Earn at least 12 other Drops.

**Data source:**

`user_collectibles`

**Measurement:**

`COUNT(user_collectibles) >= 12` before `COMPLETIONIST` is unlocked.

Completionist does not count itself and runs after Stashed so newly
earned Drops from the current check can count immediately.

**Implementation note:**

Completionist does not count itself.

This rule should run after the other collectible rules.

**Status:**

Implemented and tested.


### 16 - The Whole Picture

**Code:** `THE_WHOLE_PICTURE`

**Requirement:**

Explore all major Best Buds content areas.

The user must have at least one activity for each of:

- `DISPENSARY_VIEW`
- `ARTICLES_VIEW`
- `EDUCATION_VIEW`
- `PRODUCTS_VIEW`
- `SAFETY_VIEW`

**Data source:**

`user_activities`

**Status:**

Implemented and tested.


### 17 - Local Explore

**Code:** `LOCAL_EXPLORE`

**Requirement:**

Explore at least 5 distinct dispensaries found through
Search Near Home.

**Data source:**

Dispensary activity plus near-home search context.

**Implementation note:**

Current `DISPENSARY_VIEW` activity stores the dispensary ID but does
not identify whether the dispensary came from Search Near Home.

That context must be added before this rule is implemented.

**Status:**

Deferred until near-home activity context is finalized.


### 18 - Birthday Bud

**Code:** `BIRTHDAY_BUD`

**Requirement:**

Use Best Buds on the month and day matching the birthday stored
in the user's profile.

**Data source:**

User profile birthday and current date.

**Status:**

Implemented.


## Drop Evaluation Order

Normal activity and application-data Drops should be evaluated first.

Meta Drops should be evaluated afterward.

Recommended order:

1. Activity-based Drops
2. Saved-dispensary Drops
3. Birthday and time-based Drops
4. Stashed
5. Completionist

This allows a Drop earned during the current check to count toward
Stashed or Completionist during the same request.


## Backend Responsibility

Vue records what the user did.

Spring decides what that activity earns.

The frontend must not contain collectible unlock thresholds or decide
whether a user has earned a Drop.


## Testing Expectations

Each collectible rule should include tests for:

- requirement not yet met
- requirement exactly met
- collectible already owned
- successful unlock
- no duplicate unlock