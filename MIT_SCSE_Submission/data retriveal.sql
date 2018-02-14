SELECT AVG( 360*HOUR(a.updated_time) + 60*MINUTE(a.updated_time) + SECOND(a.updated_time)) as time_taken,b.train_schedule_id, c.distance_from_start_station FROM 
cbtlsdb.train_schedule_turn_location_update a,
cbtlsdb.train_schedule_turn b,
cbtlsdb.train_line_station c
where a.train_schedule_turn_id=b.train_schedule_turn_id
and a.last_station_id=c.previous_station_id
group by b.train_schedule_id, c.distance_from_start_station
order by b.train_schedule_id,time_taken,c.distance_from_start_station
limit 0,100000000;