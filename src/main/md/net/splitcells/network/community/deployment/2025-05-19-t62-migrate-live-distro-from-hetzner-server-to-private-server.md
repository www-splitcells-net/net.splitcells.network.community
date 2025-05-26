# Migrate live distro from Hetzner server to private server
* Issue number: [\#62](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/62)
# Task Description
Instead of renting a server at Hetzner it is more cost-efficient to host it personally (Martins Avots).
Costs:
* Hetzner Cost: 37.30 to 52,36 € = min 37.30 €
* Local Cost: Electricity + Hetzner VPS for Reverse Proxy ~ 10 to 15 € + 3.79 € = max 18.79 €
* Minimal expected savings by month: 37.30 € - 18.79 € = 18.55 €
* Expected savings over lifetime (of expected 5 years): 18.55 € * 12 months * 5 years = 1113 €

After 5 years the server may not be cost-effective enough anymore, because of energy use compared to performance.
Furthermore, I personally need a local NAS in order to back up data automatically.
So, such a server saves me from buying a dedicated NAS.
# Tasks
* [ ] Setup public reverse proxy, so that extern can access the private server indirectly without having an address for the server.
    * [ ] Rent VPS at Hetzner
    * [ ] Ensure that the traffic ect. costs of the Hetzner instance for the proxy is limited.
    * [ ] Test reverse tunneling.
    * [ ] Test with Raspberry Pi.
* [ ] Create architecture document.
    * [ ] The reverse proxy prevents certain types of DDoS of my personal internet connection and
      makes my private server not directly accessible via a public IP address.