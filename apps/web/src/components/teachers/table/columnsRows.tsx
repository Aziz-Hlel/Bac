import type { ColumnDef } from '@tanstack/react-table';
import { ArrowUp, ArrowUpDown } from 'lucide-react';
import localizedFormat from 'dayjs/plugin/localizedFormat';
import dayjs from 'dayjs';
import type { TeacherRowResponse } from '@/types/teacher/Teacher';
import { PrefixEnum, SubjectEnums, type PrefixEnumType, type SubjectEnum } from '@/enums/rest';
dayjs.extend(localizedFormat);

type TableColumnDefinition<T> = ColumnDef<T, unknown> & { accessorKey: keyof T };

const TableHeaderComp: React.FC<React.ComponentProps<'button'>> = ({ children }) => {
  return (
    <div className="truncate cursor-pointer flex items-center justify-start gap-2 whitespace-nowrap rounded-md text-sm font-medium transition-all [&_svg:not([class*='size-'])]:size-4  ">
      {children}
    </div>
  );
};

const columnsRows: TableColumnDefinition<TeacherRowResponse>[] = [
  {
    accessorKey: 'prefix',
    header: ({ column }) => {
      return (
        <TableHeaderComp onClick={() => column.toggleSorting(column.getIsSorted() === 'asc')}>
          Prefix
          {column.getIsSorted() === 'asc' && <ArrowUp />}
          {column.getIsSorted() === 'desc' && <ArrowUp className="rotate-180" />}
          {column.getIsSorted() === false && <ArrowUpDown />}
        </TableHeaderComp>
      );
    },
    cell: ({ row }) => <div className="">{PrefixEnum[row.getValue('prefix') as PrefixEnumType]}</div>,

    enableSorting: true,
    enableHiding: true,
  },
  {
    accessorKey: 'firstName',
    header: ({ column }) => {
      return (
        <TableHeaderComp onClick={() => column.toggleSorting(column.getIsSorted() === 'asc')}>
          First Name
          {column.getIsSorted() === 'asc' && <ArrowUp />}
          {column.getIsSorted() === 'desc' && <ArrowUp className="rotate-180" />}
          {column.getIsSorted() === false && <ArrowUpDown />}
        </TableHeaderComp>
      );
    },
    cell: ({ row }) => <div className="lowercase">{row.getValue('firstName')}</div>,

    enableSorting: true,
    enableHiding: true,
  },
  {
    accessorKey: 'lastName',
    header: ({ column }) => {
      return (
        <TableHeaderComp onClick={() => column.toggleSorting(column.getIsSorted() === 'asc')}>
          Last Name
          {column.getIsSorted() === 'asc' && <ArrowUp />}
          {column.getIsSorted() === 'desc' && <ArrowUp className="rotate-180" />}
          {column.getIsSorted() === false && <ArrowUpDown />}
        </TableHeaderComp>
      );
    },
    cell: ({ row }) => <div className="">{row.getValue('lastName')}</div>,

    enableSorting: true,
    enableHiding: true,
  },

  {
    accessorKey: 'publicId',
    header: ({ column }) => {
      return (
        <TableHeaderComp onClick={() => column.toggleSorting(column.getIsSorted() === 'asc')}>
          Created At
          {column.getIsSorted() === 'asc' && <ArrowUp />}
          {column.getIsSorted() === 'desc' && <ArrowUp className="rotate-180" />}
          {column.getIsSorted() === false && <ArrowUpDown />}
        </TableHeaderComp>
      );
    },
    cell: ({ row }) => <div className="">{row.getValue('publicId')}</div>,
    enableSorting: true,
    enableHiding: true,
  },
  {
    accessorKey: 'subject',
    header: ({ column }) => {
      return (
        <TableHeaderComp onClick={() => column.toggleSorting(column.getIsSorted() === 'asc')}>
          Subject
          {column.getIsSorted() === 'asc' && <ArrowUp />}
          {column.getIsSorted() === 'desc' && <ArrowUp className="rotate-180" />}
          {column.getIsSorted() === false && <ArrowUpDown />}
        </TableHeaderComp>
      );
    },
    cell: ({ row }) => <div className="">{SubjectEnums[row.getValue('subject') as SubjectEnum]}</div>,
    enableSorting: true,
    enableHiding: true,
  },
];

export default columnsRows;
