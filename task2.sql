select CustomerId, concat(FirstName,' ', LastName) as FullName, Country from customer where Country != 'USA'  /* sql-1*/
select * from customer where Country = 'Brazil'  /* sql-2*/
select InvoiceId,concat(c.FirstName,' ', c.LastName) as FullName,InvoiceDate,BillingCountry from invoice inner join customer c on invoice.CustomerId = c.CustomerId where c.Country = 'Brazil'  /* sql-3*/
select * from employee where Title like '%Sales%' '%Agent%'  /* sql-4*/
select distinct BillingCountry from invoice  /* sql-5*/
select *,concat(e.FirstName,' ', e.LastName) as FullName from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId order by i.Total desc  /* sql-6*/
select concat(c.FirstName,' ', c.LastName) as FullNameCustomer,c.Country,concat(e.FirstName,' ', e.LastName) as FullNameEmployee,Total from invoice left outer join customer c on c.CustomerId = invoice.CustomerId left join employee e on c.SupportRepId = e.EmployeeId  /* sql-7*/
select count(i.InvoiceId) as Count,YEAR(InvoiceDate) as Year from invoice i left join invoiceline i2 on i.InvoiceId = i2.InvoiceId where YEAR(InvoiceDate) in ('2009', '2011') group by YEAR(InvoiceDate)  /* sql-8*/
select COUNT(InvoiceId) from invoiceline where InvoiceId = 37  /* sql-9*/
select InvoiceId, count(*) as Number from invoiceline group by InvoiceId order by number,InvoiceId desc  /* sql-10*/
