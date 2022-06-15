select CONCAT_WS(' ', e.FirstName,e.LastName) as FullName, count(CustomerId) as Count from employee e left outer join customer c on e.EmployeeId = c.SupportRepId where c.FirstName is not null group by e.FirstName, e.LastName  /* sql-1*/
select i.BillingCountry,count(InvoiceId) as Count,sum(Total) as Sum from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry order by count(Total) desc  /* sql-2*/
select i.BillingCountry,sum(Total) from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry desc limit 1  /* sql-3*/
select i.TrackId,Name,COUNT(CustomerId) as Count from track left join invoiceline i on track.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId where InvoiceDate like '%2013%' group by Name order by count(Total) desc limit 1  /* sql-4*/
select Name,count(i.TrackId) as Count from track t left join invoiceline i on t.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId left join customer c on c.CustomerId = i2.CustomerId group by t.Name order by Count desc limit 5  /* sql-5*/
select a2.Name as Artist ,count(i.InvoiceId) as Count from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join track t on t.TrackId = invoiceline.TrackId left join album a on a.AlbumId = t.AlbumId left join artist a2 on a2.ArtistId = a.ArtistId group by a2.Name order by count(i.InvoiceId) desc limit 3  /* sql-6*/
select m.Name as Media,count(i.InvoiceId) as Count from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join track t on t.TrackId = invoiceline.TrackId left join mediatype m on m.MediaTypeId = t.MediaTypeId group by m.Name order by count(i.InvoiceId) desc limit 1  /* sql-7*/
