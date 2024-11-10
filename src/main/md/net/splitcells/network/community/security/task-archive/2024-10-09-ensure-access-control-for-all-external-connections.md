# Ensure access control for all external connections
# Task Description
There should be a set of interfaces,
that generically describes, how one exports or imports data.
Every export or import of data in any way,
should go over such an interface,
in order to mark such communication as security sensitive.

Any instance of such an interface should be guarded by some kind of access control,
that basically determines, which user session is done for any kind of external communication.
This access control has to provide a framework for the lifetime of such sessions, and
it should enforce, that other code is present in order to deal with the authorization issue.
The blocking is done by the access control.
The determination, if something is to blocked is done by the authorization policy
whereby the access control enforces,
that any message is authorized by the policy.
It is kind of a firewall.

External communication can be anything.
Like access to local files or a table.
It does not have to be communication to a public entity.

In other words, the access control enforces,
that every external interaction is authenticated,
that authorization policy is in place and
interactions are blocked according to the authorization policy.