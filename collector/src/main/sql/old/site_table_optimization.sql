drop table last_site_events;
create table last_site_events
(
	EVENT_TYPE_ID   INTEGER NOT NULL,
	TS TIMESTAMP    NOT NULL,
	ENTRY_MODE      CHAR(1),
	ENTRY_PART_1    RAW(2000),
	ENTRY_PART_2    RAW(2000),
	ENTRY           BLOB,
  primary key ( EVENT_TYPE_ID )
)
organization index
including TS
overflow
nologging
;

create or replace trigger site_events_trigger
after insert on site_events
for each row
begin

  update last_site_events
    set TS = :new.TS ,
        ENTRY_MODE = :new.ENTRY_MODE,
        ENTRY_PART_1 = :new.ENTRY_PART_1,
        ENTRY_PART_2 = :new.ENTRY_PART_2,
        ENTRY = :new.ENTRY
    where EVENT_TYPE_ID = :new.EVENT_TYPE_ID ;

  if SQL%ROWCOUNT = 0 then
    insert into last_site_events (TS, event_type_id, entry_mode, entry_part_1, entry_part_2, entry)
    values ( :new.ts , :new.event_type_id , :new.entry_mode, :new.entry_part_1, :new.entry_part_1, :new.entry);
  end if ;

end;
/

show errors for site_events_trigger;