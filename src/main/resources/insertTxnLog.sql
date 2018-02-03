insert into txnLog 
(txnId, merchantId, merchantName, amount, status, rejectReason, txnDate) 
values 
(:#${body.transctionId}, 
:#${body.merchantId}, 
:#${body.merchantName}, 
:#${body.amount}, 
:#${body.status}, 
:#${body.rejectedReason}, 
:#${body.transactedDate})
