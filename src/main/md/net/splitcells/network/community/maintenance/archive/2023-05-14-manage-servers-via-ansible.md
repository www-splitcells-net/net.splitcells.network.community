# Manage servers via Ansible
* [ ] Update servers.
* [ ] Upgrade servers.
* [ ] Raspberry Pi
* [ ] RISCV Unmatched
* [ ] Use shell scripts as a basis: https://stackoverflow.com/a/38047760

# Ansible setup

```
sudo apt install ansible
ansible-playbook --inventory-file ~/Documents/projects/net.splitcells.martins.avots.support.system/private/net.splitcells.martins.avots.support.system/src/main/ansible/inventory.ini \
	~/Documents/projects/net.splitcells.martins.avots.support.system/private/net.splitcells.martins.avots.support.system/src/main/ansible/net.splitcells.martins.avots.raspberry.v2.yaml
```

# Future Ideas
* [ ] Dry Mode for OSSI in order to generate scripts for external systems like Ansible.