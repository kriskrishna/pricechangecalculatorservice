CREATE KEYSPACE IF NOT EXISTS price_change WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE price_change;

create table IF NOT EXISTS price_change.perm_price_change
(
division_num text,
department_num text,
vendor_num text,
mark_style_num text,
price_change_num text,
pricing_event_id text,
message_sequence_num text,
rsn_id text,
pc_source_id text,
start_date timestamp,
location_zones text,
location_stores set<text>,
nrf_color_num text,
item_color_num text,
class_num text,
global_id text,
markdown_status text,
edv_flag text,
nrf_size_num text,
item_size_num text,
mark_down_status text,
current_first_ticket decimal,
new_first_ticket decimal,
current_ticket decimal,
new_ticket decimal,
date_created timestamp,
date_updated timestamp,
primary key ((department_num, vendor_num, mark_style_num), start_date, nrf_color_num, nrf_size_num))
WITH CLUSTERING ORDER BY (start_date DESC);