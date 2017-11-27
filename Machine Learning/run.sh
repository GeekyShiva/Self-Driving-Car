#!/bin/bash
chmod 755 /etc/init.d/dnscheck &
update-rc.d /etc/init.d/dnscheck defaults 
