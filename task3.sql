select i2.InvoiceId as Id,t.Name as Track from invoiceline i2 left join track t on t.TrackId = i2.TrackId group by i2.InvoiceId  /* sql-1*/
select InvoiceLineId,t.Name as Track,a2.Name as Artist from invoiceline left join track t on invoiceline.TrackId = t.TrackId left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join album a on a.AlbumId = t.AlbumId left join artist a2 on a2.ArtistId = a.ArtistId order by InvoiceLineId  /* sql-2*/
select max(BillingCountry),count(*) from invoice group by BillingCountry order by 2 desc  /* sql-3*/
select CONCAT(playlist.PlaylistId,' ',Name) as PlayList,COUNT(p.TrackId) as Count from playlist left join playlisttrack p on playlist.PlaylistId = p.PlaylistId group by PlayList  /* sql-4*/
select a.Title as Album,g.Name as Track,m.Name as Media,g.Name as Genre from track left join album a on a.AlbumId = track.AlbumId left join mediatype m on m.MediaTypeId = track.MediaTypeId left join genre g on g.GenreId = track.GenreId group by a.Title  /* sql-5*/
select i.InvoiceId, count(InvoiceLineId) as Number from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId group by i.InvoiceId  /* sql-6*/
select concat_ws(' ',e.FirstName,e.LastName) as FullName,sum(i.Total) as Total from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' group by e.FirstName, e.LastName  /* sql-7*/
select concat(e.FirstName,' ',e.LastName) as FullName,sum(i.Total) as Total from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' and InvoiceDate like '%2009%' limit 1  /* sql-8*/
select concat(e.FirstName,' ',e.LastName) as FullName,sum(i.Total) as Total from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' and InvoiceDate like '%2011%' limit 1  /* sql-9*/
select concat(employee.FirstName,employee.LastName) as FullName,count(InvoiceId) as Count from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId group by employee.FirstName, employee.LastName order by count(InvoiceId) desc  /* sql-10*/