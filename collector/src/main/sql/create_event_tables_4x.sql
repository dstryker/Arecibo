CREATE TABLE HOST_EVENTS_4X (
	HOST_ID         INTEGER NOT NULL,
	EVENT_TYPE_ID   INTEGER NOT NULL,
	TS TIMESTAMP    NOT NULL,
	ENTRY_MODE      CHAR(1),
	ENTRY_PART_1    RAW(2000),
	ENTRY_PART_2    RAW(2000),
	ENTRY           RAW(1),
	PRIMARY KEY ( HOST_ID, EVENT_TYPE_ID, TS )
)
ORGANIZATION INDEX
COMPRESS 2
OVERFLOW INCLUDING ENTRY_PART_1
nologging
partition by range ( ts )
(
	partition part_curr values less than (MAXVALUE)
)
;

CREATE TABLE PATH_EVENTS_4X (
	PATH_ID INTEGER NOT NULL,
	TYPE_ID INTEGER NOT NULL,
	EVENT_TYPE_ID INTEGER NOT NULL,
	TS TIMESTAMP NOT NULL,
	ENTRY_MODE CHAR(1),
	ENTRY_PART_1 RAW(2000),
	ENTRY_PART_2 RAW(2000),
	ENTRY RAW(1),
	PRIMARY KEY ( PATH_ID, TYPE_ID, EVENT_TYPE_ID, TS )
)
ORGANIZATION INDEX
COMPRESS 3
OVERFLOW INCLUDING ENTRY_PART_1
nologging
partition by range ( ts )
(
	partition part_curr values less than (MAXVALUE)
)
;

CREATE TABLE TYPE_EVENTS_4X (
	TYPE_ID INTEGER NOT NULL,
	EVENT_TYPE_ID INTEGER NOT NULL,
	TS TIMESTAMP NOT NULL,
	ENTRY_MODE CHAR(1),
	ENTRY_PART_1 RAW(2000),
	ENTRY_PART_2 RAW(2000),
	ENTRY RAW(1),
	PRIMARY KEY ( TYPE_ID, EVENT_TYPE_ID, TS )
)
ORGANIZATION INDEX
COMPRESS 2
OVERFLOW INCLUDING ENTRY_PART_1
nologging
partition by range ( ts )
(
	partition part_curr values less than (MAXVALUE)
)
;
