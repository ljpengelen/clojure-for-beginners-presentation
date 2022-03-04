-- :name insert-agent! :! :n
-- :doc Insert an agent and return affected row count
insert into agents (agent_code, agent_name, working_area, commission, phone_no, country)
values (:code, :name, :working-area, :commission, :phone-number, :country)

-- :name agent-by-code :? :1
-- :doc Get agent by code
select * from agents
where agent_code = :code

-- :name insert-agents! :! :n
-- :doc Insert multiple agents
insert into agents (agent_code, agent_name, working_area, commission, phone_no, country)
values :tuple*:agents
